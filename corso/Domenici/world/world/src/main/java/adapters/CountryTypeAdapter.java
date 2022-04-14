/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapters;

import it.tss.world.control.CountryStore;
import it.tss.world.entity.Country;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author tss
 */
public class CountryTypeAdapter implements JsonbAdapter<Country, JsonObject> {

    @Inject
    CountryStore store;

    @Override
    public JsonObject adaptToJson(Country entity) throws Exception {
        return entity.toJsonSlice();
    }

    @Override
    public Country adaptFromJson(JsonObject json) throws Exception {
        if (!json.containsKey("Code")) {
            return null;
        }
        return store.find(json.getJsonNumber("Code").toString()).orElseThrow(() -> new NotFoundException("CountryTypeAdapter.adaptFromJson not found"));
    }
 }
