package com.example.library.ui.theme.Screens.ProductScreen

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.library.ui.theme.data.ProductViewModel
import com.example.library.ui.theme.Models.Product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateProductsScreen(navController: NavHostController,id:String) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var name by remember { mutableStateOf("") }
        var quantity by remember { mutableStateOf("") }
        var price by remember { mutableStateOf("") }

        var currentDataRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        currentDataRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var product = snapshot.getValue(Product::class.java)
                name = product!!.name
                quantity = product!!.quantity
                price = product!!.price
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        Text(
            text = "Add product",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var bookName by remember { mutableStateOf(TextFieldValue(name)) }
        var bookQuantity by remember { mutableStateOf(TextFieldValue(quantity)) }
        var bookPrice by remember { mutableStateOf(TextFieldValue(price)) }

        OutlinedTextField(
            value = bookName,
            onValueChange = { bookName = it },
            label = { Text(text = "book name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value =bookQuantity,
            onValueChange = { bookQuantity = it },
            label = { Text(text = "book quantity *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = bookPrice,
            onValueChange = { bookPrice = it },
            label = { Text(text = "book price *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            var productRepository = ProductViewModel(navController, context)
            productRepository.updateProduct(bookName.text.trim(),bookQuantity.text.trim(),
               bookPrice.text.trim(),id)


        }) {
            Text(text = "Update")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            var productRepository = ProductViewModel(navController, context)
            productRepository.saveProduct(bookName.text.trim(),bookQuantity.text.trim(),
                bookPrice.text.trim())


        }) {
            Text(text = "save")
        }

    }
}

@Preview
@Composable
fun update() {
    UpdateProductsScreen(rememberNavController(), id = "")
}
