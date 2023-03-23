import org.junit.Assert.assertEquals
import org.junit.Test

class MainKtTest {
    //Автотесты для VK pay
    @Test
    fun comissionCalculateVkTotalOutAmountOutRange() {    //Сумма переводов выходит за пределы
        val paymentMethod = "VK Pay"
        val amount: Int = 200000                          //Значение перевода выходит за пределы
        val totalMonthPayments: Float = 50000F

        val result = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonthPayments,
            paymentMethod = paymentMethod
        )
        assertEquals(0F, result)
    }

    @Test
    fun comissionCalculateVkTotalOutAmountInRange() {    //Сумма переводов выходит за пределы
        val paymentMethod = "VK Pay"
        val amount: Int = 10000                          //Значение перевода в пределах
        val totalMonthPayments: Float = 50000F

        val result = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonthPayments,
            paymentMethod = paymentMethod
        )
        assertEquals(0F, result)
    }

    @Test
    fun comissionCalculateVkTotalInAmountInRange() {    //Сумма переводов в пределах
        val paymentMethod = "VK Pay"
        val amount: Int = 10000 //Значение перевода в пределах
        val totalMonthPayments: Float = 0F

        val result = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonthPayments,
            paymentMethod = paymentMethod
        )
        assertEquals(0F, result)
    }

    @Test
    fun comissionCalculateVkTotalInAmountOutRange() {    //Сумма переводов в пределах
        val paymentMethod = "VK Pay"
        val amount: Int = 40000 //Значение перевода выходит за пределы
        val totalMonthPayments: Float = 0F

        val result = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonthPayments,
            paymentMethod = paymentMethod
        )
        assertEquals(0F, result)
    }

    //Автотесты для Мир и Visa
    @Test
    fun comissionCalculateVisaTotalMonthInRangeAmountInRange() {    //Сумма переводов за месяц в пределах Visa
        val paymentMethod = "Visa"
        val amount: Int = 4699                      //Максимальное значение перевода с минимальной комиссией в 35 руб.
        val totalMonth: Float = 10000F

        val resultVisaMir = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonth,
            paymentMethod = paymentMethod
        )
        assertEquals(35F, resultVisaMir)
    }

    @Test
    fun comissionCalculateMirTotalMonthInRangeAmountInRange() {    //Сумма переводов за месяц в пределах Мир
        val paymentMethod = "Мир"
        val amount: Int = 4699                      //Максимальное значение перевода с минимальной комиссией в 35 руб.
        val totalMonth: Float = 10000F

        val resultVisaMir = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonth,
            paymentMethod = paymentMethod
        )
        assertEquals(35F, resultVisaMir)
    }

    @Test
    fun comissionCalculateMirTotalMonthInRangeAmountOutRange() {    //Сумма переводов за месяц в пределах Мир
        val paymentMethod = "Мир"
        val amount: Int = 4700                     //Значение когда комиссия больше минимальной
        val totalMonth: Float = 10000F

        val resultVisaMir = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonth,
            paymentMethod = paymentMethod
        )
        assertEquals((amount / 100 * 0.75F).toFloat(), resultVisaMir)
    }

    @Test
    fun comissionCalculateVisaTotalMonthInRangeAmountOutRange() {    //Сумма переводов за месяц в пределах Visa
        val paymentMethod = "Visa"
        val amount: Int = 4700                     //Значение когда комиссия больше минимальной
        val totalMonth: Float = 10000F

        val resultVisaMir = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonth,
            paymentMethod = paymentMethod
        )
        assertEquals((amount / 100 * 0.75F).toFloat(), resultVisaMir)
    }

    @Test
    fun comissionCalculateVisaTotalMonthOutRangeAmountOutRange() {    //Сумма переводов за месяц выходит за пределы Visa
        val paymentMethod = "Visa"
        val amount: Int = 4700                     //Значение когда комиссия больше минимальной
        val totalMonth: Float = 600_001F

        val resultVisaMir = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonth,
            paymentMethod = paymentMethod
        )
        assertEquals(-1F, resultVisaMir)
    }

    @Test
    fun comissionCalculateMirTotalMonthOutRangeAmountOutRange() {    //Сумма переводов за месяц выходит за пределы Мир
        val paymentMethod = "Мир"
        val amount: Int = 4700                     //Значение когда комиссия больше минимальной
        val totalMonth: Float = 600_001F

        val resultVisaMir = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonth,
            paymentMethod = paymentMethod
        )
        assertEquals(-1F, resultVisaMir)
    }

    @Test
    fun comissionCalculateMirTotalMonthOutRangeAmountInRange() {    //Сумма переводов за месяц выходит за пределы Мир
        val paymentMethod = "Мир"
        val amount: Int = 4699                      //Максимальное значение перевода с минимальной комиссией в 35 руб.
        val totalMonth: Float = 600_001F

        val resultVisaMir = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonth,
            paymentMethod = paymentMethod
        )
        assertEquals(-1F, resultVisaMir)
    }

    @Test
    fun comissionCalculateVisaTotalMonthOutRangeAmountInRange() {    //Сумма переводов за месяц выходит за пределы Visa
        val paymentMethod = "Visa"
        val amount: Int = 4699                      //Максимальное значение перевода с минимальной комиссией в 35 руб.
        val totalMonth: Float = 600_001F

        val resultVisaMir = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = totalMonth,
            paymentMethod = paymentMethod
        )
        assertEquals(-1F, resultVisaMir)
    }


    //Автотесты для Маэстро и мастеркард
    @Test
    fun comissionCalculateMaestroTotalMonthInRangeAmountOutRange() {    //Сумма переводов за месяц в пределах Maestro
        val paymentMethod = "Maestro"
        val amount: Int = 250                           //Значение перевода не в пределах
        val total: Float = 0F

        val resultMaestro = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = total,
            paymentMethod = paymentMethod
        )
        assertEquals(((amount / 1000) * 6 + 20).toFloat(), resultMaestro)
    }

    @Test
    fun comissionCalculateMastercardTotalMonthInRangeAmountOutRange() {    //Сумма переводов за месяц в пределах Mastercard
        val paymentMethod = "Mastercard"
        val amount: Int = 250                           //Значение перевода не в пределах
        val total: Float = 0F

        val resultMaestro = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = total,
            paymentMethod = paymentMethod
        )
        assertEquals(((amount / 1000) * 6 + 20).toFloat(), resultMaestro)
    }

    @Test
    fun comissionCalculateMastercardTotalMonthInRangeAmountInRange() {    //Сумма переводов за месяц в пределах Mastercard
        val paymentMethod = "Mastercard"
        val amount: Int = 10000                         //Значение перевода в пределах
        val total: Float = 0F

        val resultMaestro = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = total,
            paymentMethod = paymentMethod
        )
        assertEquals(0F, resultMaestro)
    }

    @Test
    fun comissionCalculateMaestroTotalMonthInRangeAmountInRange() {    //Сумма переводов за месяц в пределах Maestro
        val paymentMethod = "Maestro"
        val amount: Int = 10000                         //Значение перевода в пределах
        val total: Float = 0F

        val resultMaestro = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = total,
            paymentMethod = paymentMethod
        )
        assertEquals(0F, resultMaestro)
    }

    @Test
    fun comissionCalculateMaestroTotalMonthOutRangeAmountInRange() {    //Сумма переводов выходит за пределы Maestro
        val paymentMethod = "Maestro"
        val amount: Int = 10000                                 //Значение перевода в пределах
        val total: Float = 5000000F

        val resultMaestro = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = total,
            paymentMethod = paymentMethod
        )
        assertEquals(-1F, resultMaestro)
    }

    @Test
    fun comissionCalculateMastercardTotalMonthOutRangeAmountInRange() {    //Сумма переводов выходит за пределы Mastercard
        val paymentMethod = "Mastercard"
        val amount: Int = 10000                                 //Значение перевода в пределах
        val total: Float = 5000000F

        val resultMaestro = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = total,
            paymentMethod = paymentMethod
        )
        assertEquals(-1F, resultMaestro)
    }

    @Test
    fun comissionCalculateMastercardTotalMonthOutRangeAmountOutRange() {    //Сумма переводов выходит за пределы Mastercard
        val paymentMethod = "Mastercard"
        val amount: Int = 85000                                     //Значение перевода выходит за пределы
        val total: Float = 5000000F

        val resultMaestro = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = total,
            paymentMethod = paymentMethod
        )
        assertEquals(-1F, resultMaestro)
    }

    @Test
    fun comissionCalculateMaestroTotalMonthOutRangeAmountOutRange() {    //Сумма переводов выходит за пределы Maestro
        val paymentMethod = "Maestro"
        val amount: Int = 85000                                     //Значение перевода выходит за пределы
        val total: Float = 5000000F

        val resultMaestro = comissionCalculate(
            paymentAmount = amount,
            totalMonthPayments = total,
            paymentMethod = paymentMethod
        )
        assertEquals(-1F, resultMaestro)
    }

    @Test
    fun comissionCalculateNoName() {    //Неизвестная платежная система
        val paymentMethod: String = ""
        val amount: Int = 200000                          //Значение перевода любое
        val totalMonthPayments: Float = 50000F

        val result = comissionCalculate(
            paymentMethod = paymentMethod,
            paymentAmount = amount,
            totalMonthPayments = totalMonthPayments
        )
        assertEquals(-10F, result)
    }
    @Test
    fun comissionCalculateDefault() {    //Значения по умолчанию: Vk pay, 0 рублей переводов за месяц
        val amount: Int = 200000                          //Значение перевода любое
        val result = comissionCalculate(
            paymentAmount = amount,
            )
        assertEquals(0F, result)
    }
    @Test
    fun visaMirDeafult(){       //Default Visa и Мир когда минимальная комиссия
        val amount: Int = 4699

        val result = visaMir(
            amount = amount
        )
        assertEquals(35F, result)
    }
    @Test
    fun visaMirDeafultWithCommision(){       //Default Visa и Мир когда комиссия расчетная
        val amount: Int = 4700

        val result = visaMir(
            amount = amount
        )
        assertEquals((amount / 100 * 0.75F).toFloat(), result)
    }
    @Test
    fun vkPayDeafultAmountInRange(){       //Default Vk Pay
        val amount: Int = 1000 //Amount <= maxSend 15000

        val result = vkPay(
            amount = amount
        )
        assertEquals(0F, result)
    }
    @Test
    fun vkPayDeafultAmountOutRange(){       //Default Vk Pay
        val amount: Int = 100000 //Amount > maxSend 15000

        val result = vkPay(
            amount = amount
        )
        assertEquals(0F, result)
    }
    @Test
    fun masterkardMaestroDefaultAmountInRange(){       //Default Maestro и Mastercard
        val amount: Int = 10000 //Amount in 300..75000

        val result = masterkardMaestro(
            amount = amount
        )
        assertEquals(-10F, result)
    }
    @Test
    fun masterkardMaestroDefaultAmountOutRange(){       //Default Maestro и Mastercard
        val amount: Int = 100000 //Amount Out 300..75000

        val result = masterkardMaestro(
            amount = amount
        )
        assertEquals(((amount/1000)*6+20).toFloat(), result)
    }
}