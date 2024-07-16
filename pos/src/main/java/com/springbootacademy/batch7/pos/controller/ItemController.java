package com.springbootacademy.batch7.pos.controller;

import com.springbootacademy.batch7.pos.dto.CustomerDTO;
import com.springbootacademy.batch7.pos.dto.request.CustomerUpdateDTO;
import com.springbootacademy.batch7.pos.dto.request.ItemSaveRequestDTO;
import com.springbootacademy.batch7.pos.dto.request.ItemUpdateDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemDTO;
import com.springbootacademy.batch7.pos.dto.response.ItemGetResponseDTO;
import com.springbootacademy.batch7.pos.service.ItemService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO){
        String message =itemService.saveItem(itemSaveRequestDTO);
        return message;
    }
    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatus(itemName);
        return itemDTOS;
    }
    @GetMapping(
            path = "/get-by-name-with-mapstruct",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByNameAndStatusMapStruct(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByNameAndStatusMapStruct(itemName);
        return itemDTOS;
    }
    @PutMapping("/update")
    public  String updateItem(@RequestBody ItemUpdateDTO itemUpdateDTO){
        String message = itemService.updateItem(itemUpdateDTO);
        return message;
    }
    @GetMapping(
            path = "/get-by-id",
            params = "id"
    )
    public ItemDTO getItemById(@RequestParam(value = "id") int itemid){
        System.out.println("Print value " +itemid);
        ItemDTO itemDTO = itemService.getItemById(itemid);
        return itemDTO;
    }
    @GetMapping(
            path = "/get-by-names",
            params = "name"
    )
    public List<ItemGetResponseDTO> getItemByName(@RequestParam(value = "name") String itemName){
        System.out.println("Print value " +itemName);
        List<ItemGetResponseDTO> itemDTOS = itemService.getItemByName(itemName);
        return itemDTOS;
    }

}
