import {Component, OnInit} from '@angular/core';
import {TranslateService} from "@ngx-translate/core";
import {LanguageService} from "./config/language.service";
import {LocaleService} from "./service/locale.service";
import {ToastrService} from "ngx-toastr";
import {AnimalService} from "./service/animal.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'client';

  constructor(private toast:ToastrService,
private animalService:AnimalService,

    private translate: TranslateService,
              private language: LanguageService,
              private locale:LocaleService) {
  }

  ngOnInit(): void {
     this.translate.use(this.language.langStorage()+"/person");
  }
  changeLanguage(language: string) {
  this.language.switchLanguage(language+'/person');

  this.locale.changeLangServe(language).subscribe(
    {
      next:(res)=>{
    if (res==true){
      this.toast.success("Thay đổi ngôn ngữ thành công")
    }else{
      this.toast.error("Thay đổi ngôn ngữ thất bại")
    }
      },
      error:(err)=>{
        this.toast.error("Lỗi hệ thống")
        console.log(err)
      }
    }
  )
  }

  getMessageBackend(){
    this.animalService.getMessage().subscribe({
      next:(res)=>{
        this.toast.warning(res);
        console.log(res)
      },error:(err)=>{
        console.log(err)
      }
    })
  }

}
