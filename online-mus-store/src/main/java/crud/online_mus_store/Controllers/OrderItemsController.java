package crud.online_mus_store.Controllers;

import crud.online_mus_store.Services.OrderItemService;
import crud.online_mus_store.Services.OrderService;
import crud.online_mus_store.Services.ProductService;
import crud.online_mus_store.models.Order;
import crud.online_mus_store.models.OrderItem;
import crud.online_mus_store.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping("/order-items")
public class OrderItemsController {
    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String getAllOrderItems(Model model) {
        model.addAttribute("orderItems", orderItemService.getAllOrderItems());
        return "order-items";
    }

    @GetMapping("/new")
    public String showOrderItemForm(Model model) {
        model.addAttribute("orderItem", new OrderItem());
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("products", productService.getAllProducts());
        return "order-item-form";
    }

    @PostMapping("/save")
    public String saveOrderItem(@ModelAttribute OrderItem orderItem) {
        Product product = productService.getProductById(orderItem.getProduct().getProductId());
        orderItem.setPrice(product.getPrice());
        orderItemService.saveOrUpdateOrderItem(orderItem);

        updateOrderTotalAmount(orderItem.getOrder().getOrderId());
        return "redirect:/order-items";
    }

    private void updateOrderTotalAmount(int orderId) {
        Order order = orderService.getOrderById(orderId);
        List<OrderItem> orderItems = orderItemService.getOrderItemsByOrderId(orderId);

        BigDecimal totalAmount = orderItems.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotalAmount(totalAmount);
        orderService.saveOrUpdateOrder(order);
    }

    @GetMapping("/edit/{id}")
    public String editOrderItem(@PathVariable int id, Model model) {
        model.addAttribute("orderItem", orderItemService.getOrderItemById(id));
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("products", productService.getAllProducts());
        return "order-item-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderItem(@PathVariable int id) {
        orderItemService.deleteOrderItem(id);
        return "redirect:/order-items";
    }
}
