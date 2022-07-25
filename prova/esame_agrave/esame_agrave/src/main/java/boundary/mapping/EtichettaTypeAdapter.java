/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary.mapping;

import control.EtichettaStore;
import entity.Etichetta;
import java.util.Set;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.json.bind.adapter.JsonbAdapter;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author tss
 */
public class EtichettaTypeAdapter implements JsonbAdapter<Set<Etichetta>, Set<Long>>{

     @Inject
    EtichettaStore store;
    
    @Override
    public Set<Long> adaptToJson(Set<Etichetta> obj) throws Exception {

        return obj.stream().map(Etichetta::getId).collect(Collectors.toSet());
        
    }

    @Override
    public Set<Etichetta> adaptFromJson(Set<Long> obj) throws Exception {
 
            return obj.stream().map(v -> store.find(v).orElseThrow(() -> new NotFoundException("EtichettaTypeAdapter.adaptFromJson not found"))).collect(Collectors.toSet());
    
    }
    
    
    
}
