package kg.geektech.mouth8work1.di

import android.app.Application
import dagger.Component
import kg.geektech.mouth8work1.domain.model.NameModule

@Component(modules = [NameModule::class])
interface NewComponent {
    fun inject(app: Application)
}