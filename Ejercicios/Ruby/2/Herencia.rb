puts "Hello World"

module Herencia

class Persona
	def initialize(nombre)
		@nombre = nombre;
	end
	
	def andar
		result = "Soy #{@nombre} y estoy andando"
	end
	
	def to_s
		result = "Soy una persona y mi nombre es #{@nombre}"
	end
end
