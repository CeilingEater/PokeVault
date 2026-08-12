package com.st10439493.pokevault
import android.content.Context
import android.content.Intent
import android.os.Bundle

fun openIntent(context:Context,order:String,activityToOpen:Class<*>){
    //declare intent with context and class to pass value to
    val intent = Intent(context, activityToOpen)
    //pass through the string value with key "order"
    intent.putExtra("order", order)
    //if the context is not an activity
    if(context !is android.app.Activity){
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    //start the activity
    context.startActivity(intent)
}
fun shareIntent(context:Context,order:String){
    val sendIntent = Intent()
    //setting the action to tell is what to do
    sendIntent.setAction(Intent.ACTION_SEND)
    sendIntent.putExtra(Intent.EXTRA_TEXT, order)
    //sending plain text
    sendIntent.setType("text/plain")
    //show the share intent
    var shareIntent = Intent.createChooser(sendIntent, null)
    //if the context is not an activity
    if(context !is android.app.Activity){
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(shareIntent)
}
fun shareIntent(context:Context,order:Order){
    var sendIntent = Intent()
    sendIntent.setAction(Intent.ACTION_SEND)
    //creating bundle to store/add multiple values
    var shareOrderDetails = Bundle()
    shareOrderDetails.putString("productName", order.productName)
    shareOrderDetails.putString("customerName", order.customerName)
    shareOrderDetails.putString("customerPhone", order.customerPhone)
    //share the entire bundle
    sendIntent.putExtra(Intent.EXTRA_TEXT, shareOrderDetails)
    sendIntent.setType("text/plain")
    var shareIntent = Intent.createChooser(sendIntent, null)
    //if the context is not an activity
    if(context !is android.app.Activity){
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    context.startActivity(shareIntent)

}
