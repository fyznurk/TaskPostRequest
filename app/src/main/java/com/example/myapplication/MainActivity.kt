package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.remote.AuthEndpoints
import com.example.myapplication.remote.LoginResponse
import com.example.myapplication.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var authEndpoints: AuthEndpoints

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        val edtEmail: EditText = findViewById(R.id.edtEmail)
        val edtPwd: EditText = findViewById(R.id.edtPwd)
        authEndpoints = RetrofitClient(this).authEndpoints()
        btnLogin.setOnClickListener {
            authEndpoints.setLogin(
                AuthEndpoints.LoginData(
                    edtEmail.text.toString(),
                    edtPwd.text.toString()
                )
            )
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("accessToken", response.body()?.data?.accessToken!!)
                            Toast.makeText(applicationContext,response.body()?.data?.accessToken!!,Toast.LENGTH_LONG).show()
                        }else{
                            Toast.makeText(applicationContext,"invalid data",Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.d("retrofitError", t.message.toString())
                        Toast.makeText(applicationContext,t.message.toString(),Toast.LENGTH_LONG).show()
                    }
                })
        }
    }
}