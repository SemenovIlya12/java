package crud.online_mus_store.Controllers;

import crud.online_mus_store.Services.*;
import crud.online_mus_store.models.Order;
import crud.online_mus_store.models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private StatusService statusService;

    @GetMapping
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }

    @GetMapping("/new")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("statuses", statusService.getAllStatuses());
        return "order-form";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order) {
        orderService.saveOrUpdateOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String editOrder(@PathVariable int id, Model model) {
        model.addAttribute("order", orderService.getOrderById(id));
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("statuses", statusService.getAllStatuses());
        return "order-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    @GetMapping("/{orderId}/order-items")
    public String getOrderItemsForOrder(@PathVariable int orderId, Model model) {
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);
        model.addAttribute("orderItems", orderItems);
        model.addAttribute("orderId", orderId);
        return "order-items-for-order";
    }
}
