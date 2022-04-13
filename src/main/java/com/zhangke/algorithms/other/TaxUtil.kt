package com.zhangke.algorithms.other

import java.text.DecimalFormat

object TaxUtil {

    /**
     * 获取扣税总和
     *
     * @param salaryArray 每月工资
     * @param insurance   五险一金
     * @param special     专项附加扣除
     */
    fun getTaxDescription(salaryArray: DoubleArray, insurance: Double, special: DoubleArray): String {
        val taxBuilder = StringBuilder()
        val decimalFormat = DecimalFormat("0.00")
        var taxTotal = 0.0 //累计扣税
        var salaryTotal = 0.0 //工资累计金额
        for (i in salaryArray.indices) {
            salaryTotal += salaryArray[i]
            var specialTotal = 0.0
            if (special.isNotEmpty()) {
                for (item in special) {
                    specialTotal += item * (i + 1)
                }
            }
            //应纳税所得额度
            val needTax = salaryTotal - 5000 * (i + 1) - specialTotal - insurance * (i + 1)
            val thisMonthTax = when {
                needTax >= 960000 -> needTax * 0.45 - 181920 - taxTotal
                needTax >= 660000 -> needTax * 0.35 - 85920 - taxTotal
                needTax >= 420000 -> needTax * 0.30 - 52920 - taxTotal
                needTax >= 300000 -> needTax * 0.25 - 31920 - taxTotal
                needTax >= 144000 -> needTax * 0.20 - 16920 - taxTotal
                needTax >= 36000 -> needTax * 0.1 - 2520 - taxTotal
                needTax > 0 -> needTax * 0.03 - taxTotal
                else -> 0.0
            }
            taxTotal += thisMonthTax
            taxBuilder.append(
                String.format(
                    "第%s月份工资：%s，应纳税额：%s元，到手工资：%s，当前纳税总额：%s元\n\n",
                    i + 1,
                    salaryArray[i],
                    decimalFormat.format(thisMonthTax),
                    salaryArray[i] - thisMonthTax - insurance,
                    decimalFormat.format(taxTotal)
                )
            )
        }
        taxBuilder.append("累计扣税：")
        taxBuilder.append(taxTotal)
        return taxBuilder.toString()
    }
}

fun main(){
    val salaryArray = mutableListOf<Double>()
    for (i in 0 until 12){
        salaryArray += 10000.0
    }
    val insurance = 100.0
    val special = doubleArrayOf(3000.0)
    println(TaxUtil.getTaxDescription(salaryArray.toDoubleArray(), insurance, special))
}