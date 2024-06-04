package kata4;

import java.util.HashMap;
import java.util.Map;

// codewars.com/kata/54acc128329e634e9a000362
public class TCP {
    private static Map<String, String> stateTransitions = new HashMap<>();

    public static String traverseStates(String[] events) {
        createHashMap();

        StringBuilder result = new StringBuilder();
        result.append("CLOSED: ");

        for (String event : events) {
            result.append(event);
            String status = stateTransitions.getOrDefault(result.toString(), "ERROR") + ": ";
            if (status.equals("ERROR: ")) {
                return "ERROR";
            }
            result.setLength(0);
            result.append(status);
        }

        return result.toString().replaceAll(": ", "");
    }

    private static void createHashMap() {
        stateTransitions.put("CLOSED: APP_PASSIVE_OPEN", "LISTEN");
        stateTransitions.put("CLOSED: APP_ACTIVE_OPEN", "SYN_SENT");
        stateTransitions.put("LISTEN: RCV_SYN", "SYN_RCVD");
        stateTransitions.put("LISTEN: APP_SEND", "SYN_SENT");
        stateTransitions.put("LISTEN: APP_CLOSE", "CLOSED");
        stateTransitions.put("SYN_RCVD: APP_CLOSE", "FIN_WAIT_1");
        stateTransitions.put("SYN_RCVD: RCV_ACK", "ESTABLISHED");
        stateTransitions.put("SYN_SENT: RCV_SYN", "SYN_RCVD");
        stateTransitions.put("SYN_SENT: RCV_SYN_ACK", "ESTABLISHED");
        stateTransitions.put("SYN_SENT: APP_CLOSE", "CLOSED");
        stateTransitions.put("ESTABLISHED: APP_CLOSE", "FIN_WAIT_1");
        stateTransitions.put("ESTABLISHED: RCV_FIN", "CLOSE_WAIT");
        stateTransitions.put("FIN_WAIT_1: RCV_FIN", "CLOSING");
        stateTransitions.put("FIN_WAIT_1: RCV_FIN_ACK", "TIME_WAIT");
        stateTransitions.put("FIN_WAIT_1: RCV_ACK", "FIN_WAIT_2");
        stateTransitions.put("CLOSING: RCV_ACK", "TIME_WAIT");
        stateTransitions.put("FIN_WAIT_2: RCV_FIN", "TIME_WAIT");
        stateTransitions.put("TIME_WAIT: APP_TIMEOUT", "CLOSED");
        stateTransitions.put("CLOSE_WAIT: APP_CLOSE", "LAST_ACK");
        stateTransitions.put("LAST_ACK: RCV_ACK", "CLOSED");
    }
}
