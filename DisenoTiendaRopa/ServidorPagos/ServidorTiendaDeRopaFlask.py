from flask import Flask, request, jsonify

# Se crea una instancia 
# Esta app funcionara como un microservicio de pagos
app = Flask(__name__)

@app.route("/", methods=["GET"])
def home():
    
    #Endpoint básico para verificar que el servidor está en ejecución.
    #Regresa un mensaje de bienvenida y un código HTTP 200.
    return "API de Pagos Tienda de Ropa", 200

@app.route("/pago/validar", methods=["POST"])
def validar_pago():
    
    #Endpoint principal para validar pagos.
    #El servicio aplica  validación
    # Se obtiene la peticion
    datos = request.get_json() or {}

    # Se admite 
    tipo_pago = datos.get("metodo") or datos.get("tipoPago")
    monto = datos.get("monto", 0.0)

    # Por si el monto llega como cadena, se intenta convertir a número.
    if isinstance(monto, str):
        try:
            monto = float(monto)
        except ValueError:
            monto = 0.0

    aprobado = False

    # Se normaliza el método de pago a minúsculas 
    if tipo_pago is not None:
        metodo_lower = str(tipo_pago).lower()

        # Validaciones
        if metodo_lower == "efectivo":
            # Cualquier monto mayor a 0 se acepta.
            aprobado = monto > 0
        elif metodo_lower == "tarjeta":
            # Cualquier monto mayor a 0 se acepta.
            aprobado = monto > 0
        elif metodo_lower == "paypal":
            # Monto mínimo de 1 para Paypal.
            aprobado = monto >= 1
        elif metodo_lower == "transferencia":
            # Monto mínimo de 50 para Transferencia.
            aprobado = monto >= 50

    # Se regresa la respuesta en formato JSON con el campo booleano "aprobado".
    return jsonify({"aprobado": aprobado}), 200

if __name__ == "__main__":
    # Se levanta el servidor en localhost, puerto 5000
    app.run(host="localhost", port=5000, debug=True)