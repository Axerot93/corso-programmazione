/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.mapping;

import javax.json.bind.adapter.JsonbAdapter;
import entity.User;
import javax.json.JsonObject;
import control.UserStore;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author tss
 */
public class UserTypeAdapter implements JsonbAdapter<User, JsonObject>  {
    
    @Inject
    UserStore store;

    @Override
    public JsonObject adaptToJson(User entity) throws Exception {
        return entity.toJsonSlice();
    }

    @Override
    public User adaptFromJson(JsonObject json) throws Exception {
        if (!json.containsKey("id")) {
            return null;
        }
        return store.find(json.getJsonNumber("id").longValue()).orElseThrow(() -> new NotFoundException("UserTypeAdapter.adaptFromJson not found"));
    }
    
    
    
}
