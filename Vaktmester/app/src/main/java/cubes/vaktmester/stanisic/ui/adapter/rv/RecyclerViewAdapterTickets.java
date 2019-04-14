package cubes.vaktmester.stanisic.ui.adapter.rv;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

import cubes.vaktmester.stanisic.R;
import cubes.vaktmester.stanisic.data.Ticket;
import cubes.vaktmester.stanisic.utils.SpannableUtil;

public class RecyclerViewAdapterTickets extends RecyclerView.Adapter<RecyclerViewAdapterTickets.TicketViewHolder> {

    private ArrayList<Ticket> tickets;

    public static class TicketViewHolder extends RecyclerView.ViewHolder {
       public TextView ticketName, ticketCreated, ticketStatus, ticketStarted, ticketPriority;


        public TicketViewHolder(View itemView) {
            super(itemView);
            ticketName = itemView.findViewById(R.id.ticketName);
            ticketCreated = itemView.findViewById(R.id.textViewCreated);
            ticketStatus = itemView.findViewById(R.id.textViewStatus);
            ticketStarted = itemView.findViewById(R.id.textViewStarted);
            ticketPriority = itemView.findViewById(R.id.textViewPriority);
        }

    }

    public RecyclerViewAdapterTickets(ArrayList<Ticket> tickets){
        this.tickets = tickets;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ticket_recycler_view,viewGroup,false);
       TicketViewHolder tvh = new TicketViewHolder(v);
       return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder ticketViewHolder, int i) {
        Ticket ticket = tickets.get(i);

        ticketViewHolder.ticketName.setText(new StringBuilder().append("#").append(ticket.id).append(" - ").append(ticket.ticketName).toString());;

        ticketViewHolder.ticketCreated.setText(SpannableUtil.spannable("Created: ",ticket.ticketCreated),TextView.BufferType.SPANNABLE);

        ticketViewHolder.ticketStatus.setText(SpannableUtil.spannable("Status: ",ticket.ticketCreated),TextView.BufferType.SPANNABLE);

        ticketViewHolder.ticketStarted.setText(SpannableUtil.spannable("Started: ",ticket.ticketCreated),TextView.BufferType.SPANNABLE);

        ticketViewHolder.ticketPriority.setText(SpannableUtil.spannable("Priority: ",ticket.ticketCreated),TextView.BufferType.SPANNABLE);


    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

}
