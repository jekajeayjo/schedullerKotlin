package md.scheduleServicekotlin.service.impl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import md.scheduleServicekotlin.dto.PaymentDto
import md.scheduleServicekotlin.entity.PaymentEntity
import md.scheduleServicekotlin.service.ModelMapperService
import org.apache.logging.log4j.LogManager
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

@Service
class ModelMapperServiceImpl : ModelMapperService {
    private val logger = LoggerFactory.getLogger(this.javaClass)
    override fun decodeBase64(encodeString: String): String {
        val decodedBytes = Base64.getDecoder().decode(encodeString)
        return String(decodedBytes)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fromStringToList(input: String): ArrayList<Object> {
        logger.info("read FIle");
        if (input != null || input === "") {

            val gson = Gson()
            val sType = object : TypeToken<ArrayList<Object>>() {}.type
            return gson.fromJson<ArrayList<Object>>(input, sType)

        }
        return null!!;

    }

    override fun FromMapToEntity(map: Map<String, String>): PaymentEntity {
        logger.info("start adapt tmap to Entity")
        val paymentEntiy = PaymentEntity();
        map.forEach { key, value ->
            if (key != null || key != "") {
                if (key == "id") {
                    paymentEntiy.transactionId = BigDecimal(value)
                } else if (key == "ty") {
                    paymentEntiy.name = value;
                } else if (key == "ts") {
                    paymentEntiy.date = LocalDateTime.ofInstant(Instant.ofEpochSecond(value.toLong()), ZoneOffset.UTC)
                } else if (key == "pl") {
                    paymentEntiy.payload = decodeBase64(value)
                }
            }
        };
        return paymentEntiy;

    }

    override fun FromEntityToDto(entity: PaymentEntity): PaymentDto {
        logger.info("adapter paymentDto")
        var dto: PaymentDto = PaymentDto();
        dto.id = entity.id;
        dto.transactionalId = entity.transactionId;
        dto.payload = entity.payload;
        dto.ts = entity.payload;
        dto.ty = entity.name;
        return dto;
    }


}