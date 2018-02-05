package com.example.android.ceazo.preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.android.ceazo.utils.Security

/**
 * Created by yung on 2/5/18.
 */
class prefencehandler (ctx: Context) {

    companion object {
        var shared_preference: SharedPreferences? = null
        val USERNAME = "username"
        val PASSWORD = "password"

        val NAME = "name"
    }

    init {
        shared_preference = ctx.getSharedPreferences("ceazo_prefs", Context.MODE_PRIVATE)
    }

    fun saveUsername(username: String){
        shared_preference?.edit()?.putString(USERNAME, username)?.apply()
    }

    fun getUsername(): String{
        return shared_preference?.getString(USERNAME, null).toString()
    }

    fun savePassword(password: String){
        val security = Security()
        val key = security.generateKey()
        val encrypted_password = security.encryptMsg(password, key)
        shared_preference?.edit()?.putString(PASSWORD, encrypted_password)?.apply()
    }

    fun getPassword(): String? {
        val security = Security()
        val key = security.generateKey()
        return security.decryptMsg(shared_preference?.getString(PASSWORD, null)?.toByteArray(charset("UTF-8")), key)
    }

    fun saveName(name: String){
        shared_preference?.edit()?.putString(NAME, name)?.apply()
    }

    fun getName(): String{
        return shared_preference?.getString(NAME, null).toString()
    }

    fun deleteUsername(){
        shared_preference?.edit()?.remove(USERNAME)?.apply()
    }

    fun deletePassword(){
        shared_preference?.edit()?.remove(PASSWORD)?.apply()
    }

    fun deleteName(){
        shared_preference?.edit()?.remove(NAME)?.apply()
    }


}