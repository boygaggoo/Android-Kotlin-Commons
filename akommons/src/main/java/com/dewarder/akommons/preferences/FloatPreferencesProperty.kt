/*
 * Copyright (C) 2017 Artem Glugovsky
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.dewarder.akommons.preferences

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class FloatPreferencesProperty : ReadWriteProperty<SharedPreferencesProvider, Float> {

    val defaultValue: Float
    val key: String?

    constructor(defaultValue: Float, key: String?) {
        this.defaultValue = defaultValue
        this.key = key
    }

    override fun getValue(thisRef: SharedPreferencesProvider, property: KProperty<*>): Float {
        val key = key ?: property.name
        return thisRef.sharedPreferences.getFloat(key, defaultValue)
    }

    override fun setValue(thisRef: SharedPreferencesProvider, property: KProperty<*>, value: Float) {
        val key = key ?: property.name
        thisRef.sharedPreferences.save(key, value)
    }
}