package md.scheduleServicekotlin.dto

import md.scheduleServicekotlin.entity.PaymentEntity
import java.math.BigDecimal

 class PaymentDto(
        var id: BigDecimal? = null,
        var transactionalId: BigDecimal? = null,
        var ts: String? = null,
        var ty: String? = null,
        var payload: String? = null
        )

