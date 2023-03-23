fun main() {

}
fun comissionCalculate(
    paymentMethod: String = "VK Pay",
    totalMonthPayments: Float = 0F,
    paymentAmount: Int,
): Float {
    val comission: Float = when (paymentMethod) {
        "VK Pay" -> vkPay(paymentAmount, totalMonthPayments)
        "Visa", "Мир"-> visaMir(paymentAmount, totalMonthPayments)
        "Maestro",  "Mastercard" -> masterkardMaestro(paymentAmount, totalMonthPayments)
        else -> -10.00F
    }
    return comission
}
fun visaMir(amount :Int, totalMonthMoney: Float = 0F): Float {
    val maxSend: Float = 150_000F //Максимальный перевод в сутки
    val maxSendMonth: Float = 600_000F //Максимум отправленых и полученных средств за месяц
    val minComission: Float = 35F //Минимальная комиссия, оплачиваемая в любой транзакции
    val comission: Float = 0.75F //Процент комиссии для расчёта при сделках
    val countedComission = (amount / 100 * comission).toFloat()     //Рассчитываемая комиссия от сделки
    val fee: Float = when {
        countedComission<=minComission -> minComission
        else -> countedComission
    }
    return if (totalMonthMoney<=maxSendMonth)  {
        fee
    }
    else -1.00F
}
fun masterkardMaestro (amount: Int, totalMonthMoney: Float = 0F): Float {
    val promotion: Boolean = true
    val maxSend: Float = 150_000F //Максимальный перевод в сутки
    val maxSendMonth: Float = 600_000F //Максимум отправленых и полученных средств за месяц
    val fee: Float = if((amount in 300..75000)&&promotion) 0.00F else ((amount/1000)*6+20).toFloat()
    return if (totalMonthMoney<=maxSendMonth)  {
        fee
    }
    else -1.00F
}
fun vkPay(amount: Int, totalMonthPayments: Float = 0F): Float {           //Доступен ли платеж через VKpay
    val maxSend: Int = 15_000      //Максимальная величина для отправки средств за 1 раз
    val maxSendMonth: Float = 40_000F //Максимум отправленых средств за месяц
    return if ((amount<=maxSend) && (totalMonthPayments<=maxSendMonth)) 0.00F //Если соблюдаются условия перевода
    else 0.00F //Возможно увеличить комиссию в будущем, при выходе за условия
}