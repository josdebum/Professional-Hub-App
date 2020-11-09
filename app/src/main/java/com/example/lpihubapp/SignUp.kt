package com.example.lpihubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private val TAG = "CreateAccountActivity"
    private var btnCreateAccount: Button? = null
    private var mProgressBar: ProgressBar? = null
    private var mDatabaseReference: DatabaseReference? = null
    private var mDatabase: FirebaseDatabase? = null
    private var tvForgotPassword: TextView? = null
    private var email: String? = null
    private var password: String? = null
    private var username: String? = null
    private var etEmail: EditText? = null
    private var etPassword: EditText? = null
    private var etUserName: EditText? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initialise()
    }

    private fun initialise() {
        tvForgotPassword = findViewById<View>(R.id.tv_forgot_password) as TextView


        etUserName = findViewById<View>(R.id.username) as EditText

        etEmail = findViewById<View>(R.id.email) as EditText
        etPassword = findViewById<View>(R.id.password) as EditText
        btnCreateAccount = findViewById<View>(R.id.sign_up_button) as Button
        mDatabase = FirebaseDatabase.getInstance()
        mDatabaseReference = mDatabase!!.reference.child("Users")
        mAuth = FirebaseAuth.getInstance()

        tvForgotPassword!!
            .setOnClickListener { startActivity(Intent(this@SignUp,
                ForgetPasswordActivity::class.java)) }

        btnCreateAccount!!.setOnClickListener { CreateNewAccount() }

        sign_in_button.setOnClickListener {
            startActivity(Intent(this, SignIn::class.java))
        }
}

    private fun CreateNewAccount() {

        email = etEmail?.text.toString()
        password = etPassword?.text.toString()
        username = etUserName?.text.toString()

        if ( !TextUtils.isEmpty(username) &&
             !TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)) {


            mAuth!!
                .createUserWithEmailAndPassword(email!!, password!!)
                .addOnCompleteListener(this) { task ->

                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("users" , "createUserWithEmail:success")
                        val userId = mAuth!!.currentUser!!.uid

                        startActivity(Intent(this, MainActivity::class.java))
                        //Verify Email
                        verifyEmail();
                        //update user profile information
                        val currentUserDb = mDatabaseReference!!.child(userId)
                        currentUserDb.child("userName").setValue(username)

                        updateUserInfoAndUI()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.d("Error", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(this@SignUp, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }


        } else {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show()
        }

    }

    private fun updateUserInfoAndUI() {
        //start next activity
        val intent = Intent(this@SignUp, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun verifyEmail() {
        val mUser = mAuth!!.currentUser;
        mUser!!.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@SignUp,
                        "Verification email sent to " + mUser.getEmail(),
                        Toast.LENGTH_SHORT).show()
                } else {
                    Log.d("users", "sendEmailVerification", task.exception)
                    Toast.makeText(this@SignUp,
                        "Failed to send verification email.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }}