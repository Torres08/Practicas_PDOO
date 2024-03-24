#!/usr/bin/env ruby
module Parcela
    class Parcela
        
        @@FACTORALQUILERCALLE=1.0
        @@FACTORALQUILERCASA=1.0
        @@FACTORALQUILERHOTEL=4.0

        #@FACTORALQUILERCALLE=1.0
        #@FACTORALQUILERCASA=1.0
        #@FACTORALQUILERHOTEL=4.0

        @@MAX_CASAS=2;


      def initialize(n,p_c,p_e,p_ba)
        @nombre = n
        @precio_compra = p_c
        @precio_edificar = p_e
        @precio_base_alquiler = p_ba
        @num_casas = 0
        @num_hoteles = 0
       
      end
      
      def nombre
        @nombre
      end
  
      def precio_compra
        @precio_compra
      end
  
      def precio_edificar
        @precio_edificar
      end
      
      def precio_base_alquiler
        @precio_base_alquiler
      end
  
      def num_casas
        @num_casas
      end
  
      def num_hoteles
        @num_hoteles
      end


      def self.muestra
        puts @@MAX_CASAS
      end


      def precio_alquiler_completo
         @precio_base_alquiler*@@FACTORALQUILERCALLE*(1+@num_casas*@@FACTORALQUILERCASA+@num_hoteles*4*@@FACTORALQUILERHOTEL)
         #@precio_base_alquiler*F_CALLE*(1+@num_casas*F_CASA+@num_hoteles*4*F_HOTEL)
      end

      def self.setMAX_CASAS(cambio)
        @@MAX_CASAS=cambio
      end

  
      def construir_casa
        @num_casas =+ 1
      end
  
      def construir_hotel
        @num_hoteles =+ 1
      end
  
      
      
    end

      p1 = Parcela.new("P1",30,50,40)
      p2 = Parcela.new("P2",20,30,30)
  
      p1.construir_casa
      p2.construir_hotel
      
      puts "Inicio"

      puts "Parcela 1"
      puts p1.precio_alquiler_completo
      puts ""
      puts "Parcela 2"
      puts p2.precio_alquiler_completo
      puts ""
      
      Parcela.muestra

      Parcela.setMAX_CASAS(3)

      Parcela.muestra
    


  end