package md.scheduleServicekotlin.entity

import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "PAYMENT_ENTITY")
 data class PaymentEntity(
        @Id
        @GeneratedValue
        var id: BigDecimal? = null,

        @Column(name = "TRANSACTION_ID")
         var transactionId: BigDecimal? = null,
        @Column(name = "DATE")
         var date: LocalDateTime? = null,
        @Column(name = "NAME")
         var name: String? = null,
        @Column(name = "PAYLOAD")
         var payload: String? = null

) {

}