#!/usr/bin/env ruby

class Clase 
    @@variable = "De clase"
    @variable = "instancia"

    def initialize
        @variable ="instancia"
    end

    def muestraValores
        puts @@variable
        puts @variable
    end

    def self.muestraValores
        puts @@variable
        puts @variable
    end

end

objeto =Clase.new
objeto.muestraValores
Clase.muestraValores
