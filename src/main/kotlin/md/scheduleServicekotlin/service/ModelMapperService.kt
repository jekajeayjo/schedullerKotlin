package md.scheduleServicekotlin.service

import md.scheduleServicekotlin.dto.PaymentDto
import md.scheduleServicekotlin.entity.PaymentEntity
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

interface ModelMapperService {
    fun decodeBase64(encodeString: String): String;
    fun fromStringToList(input: String): ArrayList<Object>;
    fun FromMapToEntity(map: Map<String, String>): PaymentEntity;
    fun FromEntityToDto(entity:PaymentEntity):PaymentDto;
}