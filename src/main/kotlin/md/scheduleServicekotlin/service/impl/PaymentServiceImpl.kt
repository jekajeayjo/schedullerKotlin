package md.scheduleServicekotlin.service.impl

import md.scheduleServicekotlin.dto.PaymentDto
import md.scheduleServicekotlin.repository.PaymentRepository
import md.scheduleServicekotlin.service.ModelMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class PaymentServiceImpl {
    @Autowired
    lateinit var paymentRepository: PaymentRepository;
    @Autowired
    lateinit var modelMapperService: ModelMapperService

    fun getAllPayments(): List<PaymentDto> {
        var paymentsListDto: List<PaymentDto> = paymentRepository.findAll()
                .map { it -> modelMapperService.FromEntityToDto(it) }
                .toList()
        return paymentsListDto;
    }
    fun getOne( id: BigDecimal):PaymentDto
    {

return modelMapperService.FromEntityToDto(paymentRepository.findById(id).get());
    }

}