package com.hafiz.weatheruz.db.weather_data

import androidx.room.*
import com.hafiz.weatheruz.db.weather_data.TableName.TABLE_WEATHER_DATA
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDataDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(weatherDataDbEntity: WeatherDataDbEntity)

    @Delete
    suspend fun delete(weatherDataDbEntity: WeatherDataDbEntity)

    @Update
    suspend fun update(weatherDataDbEntity: WeatherDataDbEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertForecast(list: List<WeatherDataDbEntity>)

    @Transaction
    suspend fun deleteAllAndInsert( weatherList: List<WeatherDataDbEntity>) {
        deleteAll()
        insertForecast(weatherList)
    }

    @Query("select * from ".plus(TABLE_WEATHER_DATA))
     fun getWeatherList(): Flow<List<WeatherDataDbEntity>>

    @Query("DELETE FROM ".plus(TABLE_WEATHER_DATA))
    suspend fun deleteAll() : Int

}