package com.example.myartisticroom.notifications

import android.os.Parcel
import android.os.Parcelable

class Tokens (
    var code:String=""
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(code)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tokens> {
        override fun createFromParcel(parcel: Parcel): Tokens {
            return Tokens(parcel)
        }

        override fun newArray(size: Int): Array<Tokens?> {
            return arrayOfNulls(size)
        }
    }
}
