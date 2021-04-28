package md.scheduleServicekotlin.repository

import md.scheduleServicekotlin.entity.PaymentEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.math.BigDecimal

@Repository
interface PaymentRepository : CrudRepository<PaymentEntity, BigDecimal> {
}