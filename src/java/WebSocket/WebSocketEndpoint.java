
package WebSocket;
 

import Models.*;


import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.server.ServerEndpoint;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.OnMessage;
import javax.websocket.OnError;
import javax.websocket.Session;
@ServerEndpoint(
   value = "/socketApi",
   decoders = UserDecoder.class , 
   encoders =   UserEncoder.class
)
public class WebSocketEndpoint {
   	
 //   public Set<Session> sessions= new Collections.SynchronizedSet(new HashSet<>());
@OnOpen
public void open(Session session) { 

//session.getBasicRemote().
}
 @OnMessage
   public void onMessage(Session session,Persone p) throws Exception,EncodeException {
      try {
           Users user=Users.getUsersInstance();
     
       if(user.ContainsUser(p.getEmail())== false){ user.AddUser(p.getName(), p.getEmail());
      
    
         session.getBasicRemote().sendObject(p);
         
        
      }
      else throw new Exception("User already exist");}catch (Exception e){

      }

   }

@OnError
public void error(Session session, 
                  Throwable error) { }
@OnClose
public void close(Session session, 
                  CloseReason reason) { }
}
