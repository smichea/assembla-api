package test.com.assembla.realtests;

import java.util.List;

import com.assembla.Document;
import com.assembla.Ticket;
import com.assembla.TicketAssociation;
import com.assembla.TicketComment;
import com.assembla.client.AssemblaAPI;
import com.assembla.client.AssemblaClient;
import com.assembla.client.AssemblaResource;
import com.assembla.client.PagedIterator;

import org.junit.Test;

public class RealConnectionTest {
    @Test
	public void getTicket() {
        AssemblaResource api  = AssemblaAPI.create(AssemblaParams.key, AssemblaParams.secret);
        
        Ticket ticket  = api.tickets(AssemblaParams.space).getByNumber(100);
        System.out.println(ticket);
        PagedIterator<TicketComment> comments = api.ticketComments(AssemblaParams.space).getAll(ticket.getNumber());
        for(TicketComment comment:comments.asList()){
            System.out.println(comment);
        }
        List<TicketAssociation> associations = api.ticketAssociations(AssemblaParams.space).get(ticket);
        for(TicketAssociation association:associations){
            System.out.println(association);
        }
        List<Document> attachments = api.tickets(AssemblaParams.space).getAttachments(ticket.getNumber());
        for(Document attachment:attachments){
            System.out.println(attachment);
        }
	}
}
