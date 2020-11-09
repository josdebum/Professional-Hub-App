package com.example.lpihubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {
    private val TAG = "LoginActivity"
    private var mAuth: FirebaseAuth? = null
    private var currentUser: FirebaseUser? = null
    private var email: String? = null
    private var password: String? = null
    private var btnLogin: Button? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        sign_in_button.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }
        //initialise()


    }

//    private fun initialise() {
//
//        etEmail = findViewById<View>(R.id.email) as EditText
//        etPassword = findViewById<View>(R.id.password) as EditText
//        btnLogin = findViewById<View>(R.id.btnRegister) as Button
//        mDatabase = FirebaseDatabase.getInstance()
//        mDatabaseReference = mDatabase!!.reference.child("Users")
//        mAuth = FirebaseAuth.getInstance()
//
//
//
//
//        btnLogin!!.setOnClickListener { loginUser() }
//
//
//    }
//
//    private fun loginUser() {
//        email = etEmail?.text.toString()
//        password = etPassword?.text.toString()
//        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {
//
//            Log.d(TAG, "Logging in user.")
//            mAuth!!.signInWithEmailAndPassword(email!!, password!!)
//                .addOnCompleteListener(this) { task ->
//
//                    if (task.isSuccessful) {
//                        // Sign in success, update UI with signed-in user's information
//                        Log.d(TAG, "signInWithEmail:success")
//                        updateUI()
//                    } else {
//                        // If sign in fails, display a message to the user.
//                        Log.e(TAG, "signInWithEmail:failure", task.exception)
//                        Toast.makeText(this@SignIn, "Authentication failed.",
//                            Toast.LENGTH_SHORT).show()
//                    }
//                }
//        } else {
//            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun updateUI() {
//        val intent = Intent(this@SignIn, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        startActivity(intent)
//    }
//


}