/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebSocket;


import javax.json.Json;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import Models.*;

import java.io.Reader;

/**
 *
 * @author HP 820 G3
 */
class UserDecoder implements Decoder.TextStream<Persone> {

   
    @Override
    public Persone decode(Reader reader) throws DecodeException {
        Persone p = new Persone();
       try(JsonReader jreader= Json.createReader(reader)){

           JsonObject o=jreader.readObject();
                   p.setEmail(o.getString("email"));
                   p.setName(o.getString("name"));
       }
return p;
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
