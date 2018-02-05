package com.example.android.ceazo.utils

import java.io.UnsupportedEncodingException
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.spec.InvalidKeySpecException
import java.security.spec.InvalidParameterSpecException
import javax.crypto.*
import javax.crypto.spec.SecretKeySpec

/**
 * Created by yung on 2/5/18.
 */

class Security {

    companion object {
        val secret = "P05M4N_53CR3T_7ys73d9m04"
    }

    @Throws(NoSuchAlgorithmException::class, InvalidKeySpecException::class)
    fun generateKey(): SecretKey {
        return SecretKeySpec(secret.toByteArray(charset("UTF-8")), "AES")
    }

    @Throws(NoSuchAlgorithmException::class, NoSuchPaddingException::class, InvalidKeyException::class,
            InvalidParameterSpecException::class, IllegalBlockSizeException::class, BadPaddingException::class, UnsupportedEncodingException::class)
    fun encryptMsg(message: String, secret: SecretKey): String {
        /* Encrypt the message. */
        val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, secret)
        return String(cipher.doFinal(message.toByteArray(charset("UTF-8"))))
//        return cipher.doFinal(message.toByteArray(charset("UTF-8")))
    }

    @Throws(NoSuchPaddingException::class, NoSuchAlgorithmException::class, InvalidParameterSpecException::class,
            InvalidAlgorithmParameterException::class, InvalidKeyException::class, BadPaddingException::class, IllegalBlockSizeException::class,
            UnsupportedEncodingException::class)
    fun decryptMsg(cipherText: ByteArray?, secret: SecretKey): String {
        /* Decrypt the message, given derived encContentValues and initialization vector. */
        val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, secret)
        return String(cipher.doFinal(cipherText), charset("UTF-8"))
    }
}
