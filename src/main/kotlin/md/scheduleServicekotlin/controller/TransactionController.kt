package md.scheduleServicekotlin.controller

import md.scheduleServicekotlin.dto.PaymentDto
import md.scheduleServicekotlin.service.impl.PaymentServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController()
@RequestMapping("/api")
class TransactionController {
    @Autowired
    lateinit var paymentServiceImpl: PaymentServiceImpl;

    @GetMapping("/get_all")
    fun getAllPaymentList(): List<PaymentDto> {
        return paymentServiceImpl.getAllPayments();
    }

    @GetMapping("/get_one")
    fun getOne(@RequestParam("id") id: BigDecimal): PaymentDto {
        return paymentServiceImpl.getOne(id);
    }
}