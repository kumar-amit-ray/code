'''
Convert real numbers between 0 and 1 (e.g. 0.65) in binary
Youtube - https://www.youtube.com/watch?v=znOd_9O0d2s
'''
def real_number_to_binary(num):
    if num > 1: return 'ERROR'

    result = list()
    result.append('.')
    while num > 0:
        if len(result) > 32: return 'ERROR'
        b = 2*num
        if b >= 1:
            result.append('1')
            num = b-1
        else:
            result.append('0')
            num = b

    return ''.join(result)
