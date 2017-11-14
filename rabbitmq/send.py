import pika


# connect to broker (RabbitMQ server)
connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()


# create queue
channel.queue_declare(queue='hello')


# send msg
channel.basic_publish(exchange='', routing_key='hello', body='Hello World!')
print " [x] Sent 'Hello World!'"


# close connection
connection.close()
