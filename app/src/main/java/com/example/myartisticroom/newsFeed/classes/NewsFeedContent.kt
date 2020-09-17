package com.example.myartisticroom.newsFeed.classes

import android.os.Parcel
import android.os.Parcelable

data class NewsFeedContent(var explain : String? = null,
                           var username:String? = null,
                           var imageUrl : String? = null,
                           var uid : String? = null,
                           var userId : String? = null,
                           var timestamp : Long? = null,
                           var favoriteCount : Int = 0,
                           var favorites : MutableMap<String,Boolean> = HashMap()):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Long::class.java.classLoader) as? Long,
        parcel.readInt(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(explain)
        parcel.writeString(username)
        parcel.writeString(imageUrl)
        parcel.writeString(uid)
        parcel.writeString(userId)
        parcel.writeValue(timestamp)
        parcel.writeInt(favoriteCount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewsFeedContent> {
        override fun createFromParcel(parcel: Parcel): NewsFeedContent {
            return NewsFeedContent(parcel)
        }

        override fun newArray(size: Int): Array<NewsFeedContent?> {
            return arrayOfNulls(size)
        }
    }
}