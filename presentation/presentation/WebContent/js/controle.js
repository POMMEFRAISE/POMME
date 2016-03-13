$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#signin").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            ident: {
                required: true,          
            },
            mdp: {
                required: true,          
            },
        },
        messages: {
            ident: {
                required: '<span class="help-block">Vous devez entrer votre identifiant.</span>',
            },
            mdp: {
                required: '<span class="help-block">Vous devez entrer votre mot de passe.</span>',
            }
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#mdpperdu").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            mail: {
                required: true,          
            },
        },
        messages: {
            mail: {
                required: '<span class="help-block">Vous devez entrer votre adresse mail.</span>',
            }
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#modifprofil").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            mail: {
                required: true,          
            },
            nom: {
                required: true,
                minlength: 2

            },
            login: {
                required: true,          
            },
        },
        messages: {
            mail: {
                required: '<span class="help-block">Vous devez entrer votre adresse mail.</span>',
            },
            nom: {
                required: '<span class="help-block">Vous devez entrer votre nom.</span>',
                minlength: jQuery.format('<span class="help-block">Votre nom doit contenir au moins {2} caractères.</span>')
            },
            login: {
                required: '<span class="help-block">Vous devez entrer un login.</span>',
            }
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#creerclient").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            nom: {
                required: true,
                minlength: 2
            },
        },
        messages: {
            nom: {
                required: '<span class="help-block">Entrez le nom du client.</span>', 
                minlength: jQuery.format('<span class="help-block">Votre nom doit contenir au moins {2} caractères.</span>')           
            },
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#creersite").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            url: {
                required: true,         
            },
            client: {
                required: true,          
            },
        },
        messages: {
            url: {
                required: '<span class="help-block">Vous devez entrer une adresse de site web.</span>',
            },
            client: {
                required: '<span class="help-block">Vous devez sélectionner un client.</span>',
            }
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#creercontact").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            nom: {
                required: true,
                minlength: 2
            },
            client: {
                required: true,          
            },
        },
        messages: {
            nom: {
                required: '<span class="help-block">Vous devez entrer un nom.</span>',
                minlength: jQuery.format('<span class="help-block">Votre nom doit contenir au moins {2} caractères.</span>')
            },
            client: {
                required: '<span class="help-block">Vous devez sélectionner un client.</span>',
            }
        }
    });
});


$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#modifclient").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            name: {
                required: true,
                minlength: 2
            },
        },
        messages: {
            name: {
                required: '<span class="help-block">Entrez un nom de client.</span>', 
                minlength: jQuery.format('<span class="help-block">Votre nom doit contenir au moins {2} caractères.</span>')
            },
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#modifcontact").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            nom: {
                required: true,
                minlength: 2    
            },
        },
        messages: {
            nom: {
                required: '<span class="help-block">Entrez un nom.</span>', 
                minlength: jQuery.format('<span class="help-block">Votre nom doit contenir au moins {2} caractères.</span>')
            },
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#modifsite").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            url: {
                required: true,
            },
        },
        messages: {
            url: {
                required: '<span class="help-block">Vous devez entrer une adresse de site web.</span>',
            }
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#creerfreelance").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            nom: {
                required: true,  
                minlength: 2        
            }
        },
        messages: {
            nom: {
                required: '<span class="help-block">Vous devez entrer un nom.</span>',
                minlength: jQuery.format('<span class="help-block">Votre nom doit contenir au moins {2} caractères.</span>')
            }
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#modiffreelance").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            nom: {
                required: true,
                minlength: 2          
            }
        },
        messages: {
            nom: {
                required: '<span class="help-block">Vous devez entrer un nom.</span>',
                minlength: jQuery.format('<span class="help-block">Votre nom doit contenir au moins {2} caractères.</span>')
            }
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#creeruser").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            mail: {
                required: true,          
            },
            nom: {
                required: true,
                minlength: 2          
            },
            login: {
                required: true,          
            },
            rank: {
                required: true,          
            },
        },
        messages: {
            mail: {
                required: '<span class="help-block">Vous devez entrer une adresse mail.</span>',
            },
            nom: {
                required: '<span class="help-block">Vous devez entrer un nom.</span>',
                minlength: jQuery.format('<span class="help-block">Votre nom doit contenir au moins {2} caractères.</span>')
            },
            login: {
                required: '<span class="help-block">Vous devez entrer un login.</span>',
            },
            rank: {
                required: '<span class="help-block">Vous devez sélectionner un role.</span>',
            }
        }
    });
});


$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#modifuser").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            nom: {
                required: true,
                minlength: 2

            },
            rank: {
                required: true,          
            },
        },
        messages: {
            nom: {
                required: '<span class="help-block">Vous devez entrer un nom.</span>',
                minlength: jQuery.format('<span class="help-block">Votre nom doit contenir au moins {2} caractères.</span>')
            },
            rank: {
                required: '<span class="help-block">Vous devez sélectionner un role.</span>',
            }
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#demandeconges").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            type: {
                required: true,
            },
            dateDebut: {
                required: true,          
            },
            dateFin: {
                required: true,
            },
        },
        messages: {
            type: {
                required: '<span class="help-block">Vous devez sélectionner un type de congé.</span>',
            },
            dateDebut: {
                required: '<span class="help-block">Vous devez sélectionner une date de début.</span>',
            },
            dateFin: {
                required: '<span class="help-block">Vous devez sélectionner une date de fin.</span>',
            }
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#modifconges").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            type: {
                required: true,
            },
            dateDebut: {
                required: true,          
            },
            dateFin: {
                required: true,
            },
        },
        messages: {
            type: {
                required: '<span class="help-block">Vous devez sélectionner un type de congé.</span>',
            },
            dateDebut: {
                required: '<span class="help-block">Vous devez sélectionner une date de début.</span>',
            },
            dateFin: {
                required: '<span class="help-block">Vous devez sélectionner une date de fin.</span>',
            }
        }
    });
});

$(document).ready(function(){
    // validate signup form on keyup and submit

    var validator = $("#newfrais").validate({
        errorClass:'has-error',
        validClass:'has-success',
        errorElement:'div',
        highlight: function (element, errorClass, validClass) {
            $(element).closest('.form-control').addClass(errorClass).removeClass(validClass);
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".has-error").removeClass(errorClass).addClass(validClass);
        },
        rules: {
            date: {
                required: true,
            },
            lieu: {
                required: true,          
            },
            type: {
                required: true,
            },
        },
        messages: {
            date: {
                required: '<span class="help-block">Vous devez sélectionner une date.</span>',
            },
            lieu: {
                required: '<span class="help-block">Vous devez saisir un lieu.</span>',
            },
            type: {
                required: '<span class="help-block">Vous devez sélectionner un type de frais.</span>',
            }
        }

    });
});

function trim(chaine)
{
    /* Fonction de suppression des espaces  en début et en fin de chaine.
    paramètre : Chaine de caractères à traiter.
    exemple d'appel
       test1 = trim(chaine);
    */
    expreg = new RegExp('(^\s*)|(\s*$)', 'g');
    return chaine.replace(expreg,'');
}