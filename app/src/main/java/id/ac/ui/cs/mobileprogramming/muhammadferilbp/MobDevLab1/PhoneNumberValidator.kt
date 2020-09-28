package id.ac.ui.cs.mobileprogramming.muhammadferilbp.MobDevLab1

object PhoneNumberValidator {
    private const val phoneRegex = "^08\\d{9,10}\$"

    fun phoneNumberValidation(phoneNumber : String): Boolean{
        val isValid: Boolean = phoneNumber.matches(phoneRegex.toRegex())
        return(isValid)
    }
}