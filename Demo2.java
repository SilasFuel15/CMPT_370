
import java.util.ArrayList;

public class Demo2 {

    public static void main(String[] args) {

    }

}

class Packet {

    String content;
    int size;
    int destination;

    public Packet(String content, int size, int destination) {
        this.content = content;
        this.size = size;
        this.destination = destination;
    }
}

class Router {

    String r_name;
    int bufferUsed;
    int maxBuffer;
    ArrayList<String> links = new ArrayList<String>();
    ArrayList<Packet> buffer = new ArrayList<Packet>();

    public Router(String r_name, int bufferUsed, int maxBuffer) {
        this.r_name = r_name;
        this.bufferUsed = bufferUsed;
        this.maxBuffer = maxBuffer;
    }

    public void acceptPacket(Packet packet) {
        if (bufferUsed + packet.size <= maxBuffer) {
            bufferUsed += packet.size;
            buffer.add(packet);
            System.out.println("Packet accepted by " + r_name);

        } else {
            System.out.println("Buffer overflow, packet dropped.");
        }
    }

    public void sendPacket( Router dRouter) {
        Packet sent_p = buffer.remove(0);
        bufferUsed -= sent_p.size;
        dRouter.acceptPacket(sent_p);
        System.out.println("Packet sent");
        links.add("Outgoing " + dRouter.r_name + ": " + sent_p.content);

    }

}
