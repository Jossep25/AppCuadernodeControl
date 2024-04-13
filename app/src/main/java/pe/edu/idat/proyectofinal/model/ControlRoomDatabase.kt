package pe.edu.idat.proyectofinal.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.idat.proyectofinal.model.dao.UsuarioDao
import pe.edu.idat.proyectofinal.model.entity.UsuarioEntity

@Database(entities = [UsuarioEntity::class], version = 1)
public abstract class ControlRoomDatabase: RoomDatabase() {

    abstract fun usuarioDao():UsuarioDao

    companion object{
        @Volatile
        private var INSTANCE: ControlRoomDatabase? = null

        fun getDatabase(context: Context): ControlRoomDatabase{
            var tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    ControlRoomDatabase::class.java,
                    "controldb"
                ).build()
                INSTANCE = instance
                return  instance
            }
        }

    }

}