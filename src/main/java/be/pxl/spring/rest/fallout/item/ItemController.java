package be.pxl.spring.rest.fallout.item;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(ItemController.PLACEMENT_BASE_URL)
@RestController
public class ItemController {
    public static final String PLACEMENT_BASE_URL = "/item";

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;


    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity createItem(@RequestBody ItemR newItemR) {
        return ResponseEntity.ok(itemRepository.save(new Item(newItemR.getName(), newItemR.getHolder())));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity pickupItem(@PathVariable("id") String id) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Item pickedUpItem = itemService.pickUp(UUID.fromString(id), userName);

        return ResponseEntity.ok(pickedUpItem);
    }
}