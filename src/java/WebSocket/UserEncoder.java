/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;

import Models.Persone;
import Models.Users;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

class UserEncoder implements Encoder.TextStream<Persone> {

  

    @Override
    public void encode(Persone t, Writer writer) throws EncodeException, IOException {
       
JsonObject jsonUser= Json.createObjectBuilder().add("email", t.getName()).add("name",t.getName()).build();
try(JsonWriter jsonWriter = Json.createWriter(writer)){
    jsonWriter.writeObject(jsonUser);
            }

       
       }

    @Override
    public void init(EndpointConfig ec) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
