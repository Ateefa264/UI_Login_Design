package com.example.loginuidesign
import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.loginuidesign.R

@Suppress("UNUSED_ANONYMOUS_PARAMETER")
class MainActivity : AppCompatActivity() {
    private lateinit var passwordEditText: EditText
    private lateinit var showPasswordDrawable: Drawable
    private lateinit var hidePasswordDrawable: Drawable

    @SuppressLint("ClickableViewAccessibility", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        passwordEditText = findViewById(R.id.passwordEditText)
        showPasswordDrawable = resources.getDrawable(R.drawable.group, null)
        hidePasswordDrawable = resources.getDrawable(R.drawable.groupp, null)

        passwordEditText.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableRight = 2
                if (event.rawX >= (passwordEditText.right - passwordEditText.compoundDrawables[drawableRight].bounds.width())) {
                   
                    togglePasswordVisibility()
                    return@setOnTouchListener true
                }
            }
            false
        }
    }

    private fun togglePasswordVisibility() {
        if (passwordEditText.transformationMethod is PasswordTransformationMethod) {
        
            passwordEditText.transformationMethod = HideReturnsTransformationMethod.getInstance()
            passwordEditText.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_password,
                0,
                R.drawable.groupp,
                0
            )
        } else {
           
            passwordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
            passwordEditText.setCompoundDrawablesWithIntrinsicBounds(
                R.drawable.ic_password,
                0,
                R.drawable.groupp,
                0
            )
        }
       
        passwordEditText.setSelection(passwordEditText.text.length)
    }
}
