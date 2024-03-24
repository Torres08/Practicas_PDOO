
module Herencia

class Persona

	@nombre = ""

	def initialize(nombre)
		@nombre = nombre
	end
	
	def andar
		result = "Soy #{@nombre} y estoy andando"
	end
	
	def to_s
		result = "Soy una persona y mi nombre es #{@nombre}" 
	end

end


class Arbitro<Persona
	
	attr_accessor :tipo_deporte
	
	def set_deporte(deporte)
		@tipo_deporte=deporte
	end
	
	
	def to_s
		result = "Soy una arbitro , mi nombre es #{@nombre}, y arbitro en #{@tipo_deporte}" 
	end

end




class Deportista<Persona


	#Tiene un atributo de distancias y metodo get nivel&
	
	attr_accessor :distancia

	def initialize (nombre) # sobrecarga
		super(nombre)
		@distancia = 1000
		@horas_entre = 5
		
	end


	def to_s
		result = "Soy un deportista y mi nombre es #{@nombre}" 
	end
	
	def competicion_deportiva
		result = "Soy #{@nombre} y estoy en una competicion deportiva"
	end
	
	def getNivel #return de la distancia en metros supongo
		result = "Recorro #{@distancia} metros"
	end
	
	
end

class Corredor<Deportista
	
	
	attr_accessor :tipo_deportista
	
	def initialize (nombre) # sobrecarga
		super(nombre)
		@tipo_deportista="corredor"
		@distancia = 1000
		@horas_entre = 5
	end
	
	
	def to_s
		result = "Soy un deportista y corredor y mi nombre es #{@nombre}" 
	end
	
	def getNivel
	    	# CORREDOR ES DISTANCIA + HORAS
	    	@total = @distancia + @horas_entre
	    	return @total
		
	end
end

class Nadador<Deportista
	
	def initialize (nombre) # sobrecarga
		super(nombre)
		@tipo_deportista="nadador"
		@distancia = 1000
		@horas_entre = 5
	end
	
	def getNivel
	    	# CORREDOR ES DISTANCIA + HORAS
	    	@total = @distancia/3 + @horas_entre+2
	    	#result = "Soy un deportista y corredor y mi nombre es #{@nombre} y he entrenado #{@total} "
	    	return @total;
		
	end
	
	def to_s
		result = "Soy un deportista y nadador y mi nombre es #{@nombre}" 
	end

end

class Competicion

	attr_accessor :arbitro , :jugadores
	
	def initialize  # sobrecarga
		@jugadores = Array.new
	end

	

	def obtenerGanador
	
		jugadores.sort do |a, b|
		  case
		  when a.getNivel < b.getNivel
		    -1
		  when a.getNivel > b.getNivel
		    1
		  
		  end
		end 
		
		jugadores.sort	
		
		
		result = " 1º es #{@jugadores[0]} / 2º es #{@jugadores[1]} / 3º es #{@jugadores[2]}"		
	
	end
	
	def setArbitro(arbitro)
		@arbitro = arbitro
	end
	
	def addJugador(deportista)
		@jugadores.push(deportista)
	end
	
	def comprobarCompeticion
		
		for i in jugadores do
			
			if jugadores[i].tipo_deporte != arbitro.tipo_deporte
				puts "false"
			
			else
				puts "true"
			end
		end	
			
	
	end
	
end




#main

Pepe = Persona.new("Pepe")
Maria = Arbitro.new("Maria")
Jose = Nadador.new("Jose")
Felipe = Corredor.new("Felipe")

Juego =Competicion.new

#puts ""
#puts Pepe.andar
#puts Pepe.to_s
#puts ""

#puts Maria.andar
#puts Maria.to_s
#puts ""


puts ""
#puts Jose.competicion_deportiva
puts Jose.getNivel


puts Felipe.getNivel


puts ""
Maria.set_deporte("Natacion")
puts Maria.to_s

puts ""
Juego.setArbitro(Maria)

Juego.addJugador(Felipe)
Juego.addJugador(Jose)

puts Juego.obtenerGanador








end
