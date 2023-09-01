package withchat.web.chatroom.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Service;




@ServerEndpoint("/socket")
@Service
public class ChatController{
    private static final List<Session> session = new ArrayList<Session>();
    private static Set<Session> CLIENTS = Collections.synchronizedSet(new HashSet<>());
    
    @OnOpen
    public void open(Session newUser) {
        session.add(newUser);
    }

    @OnMessage
    public void getMsg(Session recieveSession, String msg) {
        for (int i = 0; i < session.size(); i++) {
            if (!recieveSession.getId().equals(session.get(i).getId())) {
                try {
                    session.get(i).getBasicRemote().sendText("상대 : "+msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    session.get(i).getBasicRemote().sendText("나 : " +msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @OnClose
    public void close(Session oldUser) {
       session.remove(oldUser);
    }
    
    @OnError
    public void handleError(Throwable t) {
       t.printStackTrace();
    }
}