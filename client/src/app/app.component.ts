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
export class AppComponent implements OnInit {
  title = 'client';

  constructor(private toast: ToastrService,
              private animalService: AnimalService,
              private translate: TranslateService,
              private language: LanguageService,
              private locale: LocaleService) {
  }

  ngOnInit(): void {
    this.translate.use(this.language.langStorage() + "");
  }

  changeLanguage(language: string) {
    this.language.switchLanguage(language + '');
    this.locale.changeLangServe(language).subscribe(
      {
        next: (res) => {
          if (res == true) {
          } else {
            this.toast.error(this.translate.instant("error.language"))
          }
        },
        error: (err) => {
          this.toast.error(this.translate.instant("error.language"))
          console.log(err)
        }
      }
    )
  }

  getMessageBackend() {
    this.animalService.getMessage().subscribe({
      next: (res) => {
        this.toast.warning(res);
        console.log(res)
      }, error: (err) => {
        this.toast.warning(err.error.message)
        console.log(err)
      }
    })
  }

}
