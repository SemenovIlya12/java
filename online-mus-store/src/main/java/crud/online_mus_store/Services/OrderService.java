package crud.online_mus_store.Services;

import crud.online_mus_store.models.Order;
import crud.online_mus_store.models.OrderItem;
import crud.online_mus_store.repos.OrderItemRepository;
import crud.online_mus_store.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order saveOrUpdateOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    public void updateOrderTotalAmount(int orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            List<OrderItem> orderItems = orderItemRepository.findByOrderOrderId(orderId);

            BigDecimal totalAmount = orderItems.stream()
                    .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            order.setTotalAmount(totalAmount);
            orderRepository.save(order);
        }
    }
}
