package com.nikolas.studysetapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardRowHolder> {

    ArrayList<Card> cardData;
    Context context;
    MyClickInterface myClickInterface;
    int position;

    public CardAdapter(ArrayList<Card> cardData, Context context, MyClickInterface myClickInterface) {
        this.cardData = cardData;
        this.context = context;
        this.myClickInterface = myClickInterface;
    }

    @NonNull
    @Override
    public CardRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.termcard, parent, false);
        return new CardRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardRowHolder holder, int position) {
        holder.term.setText(cardData.get(position).getTerm());
    }

    @Override
    public int getItemCount() {
        return cardData.size();
    }


    //Inner class for row holder
    class CardRowHolder extends RecyclerView.ViewHolder {
        TextView term;

        public CardRowHolder(@NonNull View itemView) {
            super(itemView);
            term = itemView.findViewById(R.id.term);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myClickInterface.onItemClick(getAdapterPosition());
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    deleteDialog(position);
                    return true;
                }
            });
        }

        //Method for deletion of a card
        private void deleteDialog(final int position) {
            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setTitle("Delete Item");
            builder.setMessage("Are you sure you want to delete this item?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int p) {
                    cardData.remove(position);
                    notifyItemRemoved(position);
                }
            });
            builder.setNegativeButton("No", null);
            builder.show();
        }
    }

    interface MyClickInterface {
        void onItemClick(int positionOfTheCard);
    }

}
